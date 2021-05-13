REM Untested. I did not have access to a Windows machine to test this.
docker run -it --rm -v "%cd%:/w" -w /w gradle:7.0-jdk11 gradle %*
