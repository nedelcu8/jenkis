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

