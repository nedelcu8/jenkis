def incrementVersion(){
    echo "incrementing version"
    sh ' mvn build-helper:parse-version version:set \
    -DnewVersion=\\\${parsedVersion.majorVersion}.\\\${parsedVersion.minorVersion}.\\\${parsedVersion.nextIncrementalversion} \
    versions:commit'


}


def buildJar() {
    echo "building the application..."
    sh 'mvn package'
} 

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t nedelcu8/my-repo:jma-2.1 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push nedelcu8/my-repo:jma-2.1'
    }
} 

def deployApp() {
    echo 'deploying the application...'
} 

return this