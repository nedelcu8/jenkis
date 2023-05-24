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
        when {
          expression{
            BRANCH_NAME == 'circleci-project-setup'
          }
        }
        script{
          gv.buildJar()
        }
      }
    }

    stage("build image"){
      steps{
        when {
          expression{
            BRANCH_NAME == 'circleci-project-setup'
          }
        }
        script{
          gv.buildImage()
        }          
      }
    }

    stage("deploy"){
      steps{
        script{
        when {
          expression{
            BRANCH_NAME == 'circleci-project-setup'
          }
        }
          gv.deployApp()
        }
      }
    }

  }


}

