def gv
pipeline
{
  agent any
  parameters{
    choice(name:'VERSION' , choices: ['11.1.0' , '11.1.1','12.0.0'] , description:'')
    booleanParam(name:'executeTest' , defaultValue: true , description: '')

  }
  stages{
    stage("init"){
      steps {
        script {
          gv = load "script.groovy"
        }
      } 
    }

    stage("buid"){

      steps {
        echo 'build the app'
        echo 'build the app'
      } 

    }

    stage("test"){

      when{

        expression {
          params.executeTest
        }

      }

      steps {

        echo 'test the app'

      } 

    }
    stage("deploy"){

 
        input {
          message "select the env "
          ok "env done"
          parameters {
            choice(name:'ENV1' , choices: ['dev' , 'stage','prod'] , description:'')
            choice(name:'ENV2' , choices: ['dev' , 'stage','prod'] , description:'')
            choice(name:'ENV3' , choices: ['dev' , 'stage','prod'] , description:'')
            

          }
        }
      steps {
        script {

          gv.deployApp()
          echo "deplaying with ${ENV1}"
          echo "deplaying with ${ENV2}"
          echo "deplaying with ${ENV3}"

        }

      }

    } 

  }

} 
