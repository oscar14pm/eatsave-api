pipeline {
  agent any
  tools {
    maven 'MAVEN_3_8_5'
    jdk 'JDK_17_0_3_1'
  }
  stages {
    stage('Compile Stage') {
      steps {
        withMaven(maven: 'MAVEN_3_8_5') {
          bat 'mvn clean compile'
        }
      }
    }

    stage('Testing Stage') {
      steps {
        withMaven(maven: 'MAVEN_3_8_5') {
          bat 'mvn test'
        }
      }
    }

    stage('Package Stage') {
      steps {
        withMaven(maven: 'MAVEN_3_8_5') {
          bat 'mvn package'
        }
      }
    }
  }
}
