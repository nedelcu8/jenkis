def gv

pipeline {
  
  agent any
  tools{
    maven 'maven_version-3.9.2'
  }
  stages {

    stage("init"){
      steps{
        script{
          gv = load("script.groovy")
          echo "Executing pipeline for branch $BRANCH_NAME"
        }
      }
    }

    stage("build jar "){
      steps{
        script{
          gv.buildJar()
        }
      }
    }

    stage("build image"){
      steps{
        script{
          gv.buildImage()
        }          
      }
    }

    stage("deploy"){
      steps{
        script{
          gv.deployApp()
        }
      }
    }

  }


}

