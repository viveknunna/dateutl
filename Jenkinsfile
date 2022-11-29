pipeline {
    agent any



   stages {
        stage('pre-build') {
            steps {
                sh''' 
                sudo rm -rf dateutl
                git clone https://github.com/viveknunna/dateutl.git
                
                
                '''
            }
        }
     stage('build') {
            steps {
                sh'''
                cd dateutl
                mvn clean package
                sudo docker build -t dateutl .
                
                '''
            }
        }
	stage('push') {
            steps {
                sh'''
		sudo aws ecr get-login-password --region us-east-1 | sudo docker login --username AWS --password-stdin 778322075190.dkr.ecr.us-east-1.amazonaws.com
                sudo docker tag dateutl:latest 778322075190.dkr.ecr.us-east-1.amazonaws.com/dateutl:latest
				sudo docker push 778322075190.dkr.ecr.us-east-1.amazonaws.com/dateutl:latest
                '''
            }
        }


   stage('Deploy') {
    
            steps {
                sh'''
        sudo docker stop dateutl && sudo docker rm dateutl
                sudo docker run --name dateutl -d -p 8090:8081 -t 778322075190.dkr.ecr.us-east-1.amazonaws.com/dateutl:latest
                echo 'containers running'



                
                
                '''
            }
        }



   }
}
