pipeline
{
  agent any
  parameters{
    choice(name:'VERSION' , choices: ['11.1.0' , '11.1.1','12.0.0'] , description:'')
    booleanParam(name:'executeTest' , defaultValue: true , description: '')

  }
  stages{
 
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
        echo 'deploy the app'
        echo "deplay version ${params.VERSION} "
      }
    } 

  }

} 
