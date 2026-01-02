<#
.SYNOPSIS
    Sets version of plug-in project with maven tycho plug-in
#>
param(
    # Path to .txt file with paths to git repositories
    [Parameter(Mandatory = $true)]
    [string]$ProjectPath,
    # Fully specified version, e.g. 1.1.5 or major, minor or patch update
    [Parameter(Mandatory = $true)]
    [string]$NewVersion
)

Function updatePomVersion([string]$ProjectPath, [string]$OldVersion, [string]$NewVersion) {
    $fqv = $NewVersion + "-SNAPSHOT"
    if ($fqv -eq $OldVersion) {
        Write-Host -ForegroundColor Yellow "Version already matches $fqv"
        return
    }
    Set-Location $ProjectPath
    Write-Host "Updating version from $OldVersion to $fqv"
    mvn tycho-versions:set-version -DnewVersion="$fqv" -q

    # set output variable for github actions
    "NEW_VERSION=$NewVersion" | Out-File -FilePath $env:GITHUB_OUTPUT -Append
}

if (!(Test-Path $ProjectPath)) {
    Write-Error "Given ProjectPath '$ProjectPath' does not exist"
    return
}

$ProjectPath = (Resolve-Path $ProjectPath)

if (!(Test-Path "$ProjectPath\pom.xml")) {
    Write-Error "Folder '$ProjectPath' does not contain a pom.xml file"
    return
}

# read pom.xml file
[xml]$pom = Get-Content -Path "$ProjectPath\pom.xml"

$version = $pom.project.version

if ($NewVersion -match "^\d+\.\d+\.\d+$") {
    updatePomVersion -ProjectPath $ProjectPath -OldVersion $version -NewVersion $NewVersion
}
else {

    # Determine snapshot part of version
    $version = $version.Split("-SNAPSHOT")[0]

    # extract all parts of version
    $versionParts = $version.Split(".");
    $majorNumber = [int]$versionParts[0];
    $minorNumber = [int]$versionParts[1];
    $patchNumber = [int]$versionParts[2];

    if ($NewVersion -eq "major") {
        $majorNumber += $majorNumber
        $minorNumber = 0
        $patchNumber = 0
    }
    else {
        if ($NewVersion -eq "minor") {
            $minorNumber += 1
            $patchNumber = 0
        }
        else {
            if ($NewVersion -eq "patch") {
                $patchNumber += 1
            }
            else {
                Write-Error "Either a concrete version (e.g. 1.1.5) or 'major', 'minor' or 'patch' must be specified"
                return

            }
        }
    }

    updatePomVersion -ProjectPath $ProjectPath -OldVersion $pom.project.version -NewVersion "$majorNumber.$minorNumber.$patchNumber"
}