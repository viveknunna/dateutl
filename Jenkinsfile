pipeline {
    agent any



   stages {
        stage('pre-build') {
            steps {
                sh''' 
                sudo rm -rf docker-java
                git clone https://github.com/Ikrao/docker-java.git
                
                
                '''
            }
        }
     stage('build') {
            steps {
                sh'''
                cd docker-java/docker-spring-boot
                mvn clean package
                sudo docker build -t spring-boot:1.0 .
                
                '''
            }
        }
	stage('push') {
            steps {
                sh'''
                sudo docker tag spring-boot:1.0 viveknunna/spring-boot:1.0
				sudo docker push viveknunna/spring-boot:1.0
                '''
            }
        }


   stage('Deploy') {
    
            steps {
                sh'''
        sudo docker stop springboot && sudo docker rm springboot
                sudo docker run --name springboot -d -p 8090:8080 -t spring-boot:1.0
                echo 'containers running'



                
                
                '''
            }
        }



   }
}
