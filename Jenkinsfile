pipeline
{
  agent any
  parameters{
    choise(name:'VERSION' , choises: ['11.1.0' , '11.1.1','12.0.0'] , description:'')
    boolParam(name:'executeTest' , defaultValue: true , description: '')

  }
  stages{
 
    stage("buid"){
      steps {
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
