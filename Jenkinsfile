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

      steps {

        script {

          gv.deployApp()

        }

      }
      
    } 

  }

} 
