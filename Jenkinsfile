node {
    def mvnHome

    stage('Preparation') {
        echo 'Preparing Project Workarea...'
        git 'https://github.com/agelop/Application2.git'
    }

    stage('Build') {
        echo 'Building the Project...'
        build 'aos_build'
    }

    stage('Deploy to QA') {
        echo 'Deployment to QA Environment...'
    }

    stage('Unit Tests and Code Coverage') {
        echo 'Executing Unit Tests and Code Coverage'
        build 'aos_unit_testing_and_code_coverage'
    }

    stage('Integration and API Tests') {
        echo 'Executing Integration and API Tests'
        build 'aos_integration_testing'
    }

    stage('Acceptance Tests') {
        echo 'Executing BDD Acceptance Tests'
        build 'aos_acceptance_testing'
    }

    stage('Regression Tests') {
        echo 'Executing E2E Regression Tests with Selenium'
        build 'aos_regression_testing_selenium'
    }
}