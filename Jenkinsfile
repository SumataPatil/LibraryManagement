pipeline {
   agent any

   tools {
      // Install the Maven version configured as "M3" and add it to the path.
      maven "mavenJenkins"
      jdk 'java8'
   }

   stages {
      stage('checkout') {
         steps {
           
            // Get some code from a GitHub repository
          //echo 'hiiiii'
       git credentialsId: '5154d130-7f9d-4711-8ec5-1f776304eadb', url: 'https://github.com/SumataPatil/LibraryManagement'
echo 'hiii'
            // Run Maven on a Unix agent.
            //sh "mvn -Dmaven.test.failure.ignore=true clean package"

            // To run Maven on a Windows agent, use
            // bat "mvn -Dmaven.test.failure.ignore=true clean package"
         }

         
      }
      stage('SonarQube analysis') {
          steps {
     withSonarQubeEnv('LocalSonar') {
     bat 'C:/Softwares/sonar-scanner-4.3.0.2102-windows/bin/sonar-scanner -X -Dsonar.java.libraries=target/classes '
      
     
        
    } 
  }
      }
       stage('Quality Gate') {
          steps {
              script{
                  sleep(60);
     timeout(time: 1, unit: 'HOURS') { // Just in case something goes wrong, pipeline will be killed after a timeout
    def qg = waitForQualityGate() // Reuse taskId previously collected by withSonarQubeEnv
    if (qg.status != 'OK') {
     
      emailext body: 'QualityGate failed with status  '+ ${qg.status}, subject: 'Build status for ${JOB_NAME}', to: 'ac68830@centurylink.com'
       error "Pipeline aborted due to quality gate failure: ${qg.status}"
    }
  
    }
     
     }    
    
  }
      } 
      stage('Build') {
         steps {
          

            // Run Maven on a Unix agent.
            //sh "mvn -Dmaven.test.failure.ignore=true clean package"

            // To run Maven on a Windows agent, use
             bat "mvn -Dmaven.test.failure.ignore=true clean package"
         }

         
      }
   }
}