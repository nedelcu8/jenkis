def incrementVersion(){
    echo "incrementing version"
    sh   'mvn build-helper:parse-version versions:set \
          -DnewVersion=\\\${parsedVersion.majorVersion}.\\\${parsedVersion.minorVersion}.\\\${parsedVersion.nextIncrementalVersion} \
          versions:commit'
          def matcher = readFile('pom.xml') =~'<version>(.+)</version>'
          def version = matcher[0][1] 
          env.IMAGE_NAME = "$version-$BUILD_NUMBER"
}

def buildJar() {
    echo "building the application..."
    sh 'ls -a'
    sh 'mvn clean package'
    sh 'mvn package'
} 

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh "docker build -t nedelcu8/my-repo:$IMAGE_NAME ."
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh "docker push nedelcu8/my-repo:$IMAGE_NAME"
    }
} 

def deployApp() {
    echo 'deploying the application...'
} 

return this
