pipeline {
    agent any

    stages {
        stage('Git Checkout Repositorio') {
            steps {
                url: 'https://github.com/packsendme/packsendme-roadwaybre-lib.git'
            }
        }
        stage('Java Build') {
          steps {
                sh 'mvn clean install'
            }
        }
    }
}