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
          echo "Executing pipeline for branch $BRANCH_NAME"
          echo "Executing pipeline for branch $BRANCH_NAME"
        }
      }
    }

    stage("build jar "){
        when {
          expression{
            BRANCH_NAME == 'circleci-project-setup'
          }
        }      
      steps{
        script{
          gv.buildJar()
        }
      }
    }

    stage("build image"){
        when {
          expression{
            BRANCH_NAME == 'circleci-project-setup'
          }
        }
      steps{
        script{
          gv.buildImage()
        }          
      }
    }

    stage("deploy"){
        when {
          expression{
            BRANCH_NAME == 'circleci-project-setup'
          }
        }
      steps{
        script{
          gv.deployApp()
        }
      }
    }

  }


}

