pipeline {
	agent {label 'slave-2'}
	stages {
		stage("Compile") {
			steps {
				sh "./gradlew compileJava"
			}
		}
		stage("Unit test") {
			steps {
				sh "./gradlew test"
			}
		}
		stage("Code coverage") {
			steps {
				sh "./gradlew jacocoTestReport"
				publishHTML (target: [
					reportDir: 'build/reports/jacoco/test/html',
					reportFiles: 'index.html',
					reportName: "JaCoCo Report"
				])
				sh "./gradlew jacocoTestCoverageVerification"
			}
		}
		stage("Static code analysis") {
			steps {
				sh "./gradlew checkstyleMain"
				publishHTML (target: [
					reportDir: 'build/reports/checkstyle/',
					reportFiles: 'main.html',
					reportName: "Checkstyle Report"
				])
			}
		}
		stage("Paranoid test with SonarQube") {
			steps {
				sh "./gradlew sonarqube \
  					-Dsonar.projectKey=Calculator \
					-Dsonar.host.url=http://172.17.0.4:9000 \
					-Dsonar.login=67a289199a005285d3865117078c6e98e2585c9a"
			}
		}
		stage("Packaging") {
			steps {
				sh "./gradlew build"
			}
		}
		stage("Docker build") {
			steps {
				sh "docker build -t myregistrydomain.com:5000/calculator ."
			}
		}
		stage("Docker push") {
			steps {
				sh "docker push myregistrydomain.com:5000/calculator"
			}
		}
		stage("Deploy to staging") {
			steps {
				sh "docker run -d --rm -p 8765:8080 --name calculator myregistrydomain.com:5000/calculator"
			}
		}
		stage("Acceptance test") {
			steps {
				sleep 60
				sh "./acceptance_test.sh"
			}
		}
	}
	post {
		always {
			sh "docker stop calculator"
		}
	}
}
