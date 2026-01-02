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

$cwd = Get-Location

Function updatePomVersion([string]$ProjectPath, [string]$OldVersion, [string]$NewVersion) {
    Set-Location $ProjectPath
    Write-Host "Updating version from $OldVersion to $NewVersion"
    if (!$TestMode) {
        mvn tycho-versions:set-version -DnewVersion="$NewVersion" -q
    }
    Set-Location $cwd
}

if (!(Test-Path $ProjectPath)) {
    Write-Error "RepoPath does not exist"
    return
}

$ProjectPath = (Resolve-Path $ProjectPath)

if (!(Test-Path "$ProjectPath\pom.xml")) {
    Write-Error "Folder does not contain a pom.xml file"
    return
}

# read pom.xml file
[xml]$pom = Get-Content -Path "$ProjectPath\pom.xml"

$version = $pom.project.version

if ($NewVersion -match "^\d+\.\d+\.\d+$") {
    $NewVersion += "-SNAPSHOT"
    if ($NewVersion -eq $version) {
        Write-Host -ForegroundColor Yellow "Version already matches $NewVersion"
        return
    }
    updatePomVersion -RepoPath $ProjectPath -OldVersion $version -NewVersion $NewVersion
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

    $NewVersion = "$majorNumber.$minorNumber.$patchNumber-SNAPSHOT"

    if ($NewVersion -eq $version) {
        Write-Host -ForegroundColor Yellow "Version already matches $NewVersion"
        return
    }

    updatePomVersion -RepoPath $ProjectPath -OldVersion $pom.project.version -NewVersion $NewVersion
}