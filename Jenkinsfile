pipeline {
  
  agent any
  tools{
    maven 'maven_version-3.9.2'
  }
  stages {

    stage("build jar "){
      steps{
        script{
          echo "buing the app"
          sh 'mvn package'
        }
      }
    }
    stage("build image"){
      steps{
        script{
          echo "buing the docker image"
          withCredentials([usernamePassword(credentialsId: 'docker-hub' , passwordVariable: 'PASS' ,usernameVariable: 'USER')]){
            sh 'docker build -t nedelcu8/my-repo:jma-2.0 .'
            sh "echo $PASS | docker login -u $USER --passsword-stdin"
            sh 'docker push nedelcu8/my-repo:jma-2.0'
          }          
        }
      }
    }
    stage("deploy"){
      steps{
        script{
          echo "deploy the app"
        }
      }
    }

  }

}