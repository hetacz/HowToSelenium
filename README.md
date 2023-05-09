# Parallel Selenium framework with multiple browsers and I18n support

[![CI](https://github.com/hetacz/HowToSelenium/actions/workflows/gradle.yml/badge.svg)](https://github.com/hetacz/HowToSelenium/actions/workflows/gradle.yml)

This is a sample selenium framework that supports parallelization and multiple browsers.

## Available parameters

Parameters can be passed via suite file, a command line or directly in run settings (VM options).
One should pass parameters using the following syntax: `-DparameterName=parameterValue`.
If using different suite file, it has to be selected manually or passed as a CLI or VM option parameter.

### 1. Headless

- **false** – default
- true\
  `-Dheadless=true`

### 2. Browser

- **Chrome** – default
- Firefox
- Edge\
  `-Dbrowser=EDGE`

### 3. SuiteFile

- **testng/testng.xml** – default\
  By default, suite files are looked for in the `testng` directory.\
  `-DsuiteFile='file1.xml'`
