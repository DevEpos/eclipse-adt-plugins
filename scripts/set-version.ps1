<#
.SYNOPSIS
    Sets version of plug-in project with maven tycho plug-in
#>
param(
    # Path to the root of the maven project
    [Parameter(Mandatory = $true)]
    [string]$ProjectPath,
    # Fully specified version, e.g. 1.1.5
    [Parameter(Mandatory = $true)]
    [string]$NewVersion
)

$cwd = Get-Location

Function updatePomVersion([string]$ProjectPath,[string]$OldVersion,[string]$NewVersion) {
    Set-Location $ProjectPath
    Write-Host "Updating version from $OldVersion to $NewVersion"
    if (!$TestMode) {
        mvn tycho-versions:set-version -DnewVersion="$NewVersion" -q
    }
    Set-Location $cwd
}

if (!(Test-Path $ProjectPath)) {
    Write-Error "ProjectPath does not exist"
    return
}

if ($NewVersion -and !($NewVersion -match "^\d+\.\d+\.\d+$")) {
    Write-Error "The supplied version $NewVersion is invalid. Use Major.Minor.Patch"
    return
}

$ProjectPath = (Resolve-Path $ProjectPath)

if (!(Test-Path "$ProjectPath\pom.xml")) {
    Write-Error "Folder does not contain a pom.xml file"
    return
}

[xml]$pom = Get-Content -Path "$ProjectPath\pom.xml"

$version = $pom.project.version

$NewVersion += "-SNAPSHOT"
if ($NewVersion -eq $version) {
    Write-Host -ForegroundColor Yellow "Version already matches $NewVersion"
    return
}
updatePomVersion -ProjectPath $ProjectPath -OldVersion $version -NewVersion $NewVersion