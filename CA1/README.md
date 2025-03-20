
# DevOps Assignment - Technical Report

**Author:** Fernando Moreira

**Date:** 18/03/2025

**Discipline:** DevOps

**Program:** SWitCH DEV

**Institution:** ISEP - Instituto Superior de Engenharia do Porto

## Table of Contents

- [Introduction](#introduction)

## Introduction
This technical report documents the steps and analysis taken to complete the assignment. It covers the creation of a repository on GitHub, the steps for initializing the local repository, managing issues, implementing features, and working with tags and commits. Each section includes a tutorial-style walkthrough, justifications for decisions, and details of the implementation process.

---

## Part 1: Creating the Repository and Initial Setup

### 1. Create a Repository on GitHub

First, create a repository on GitHub to store your project:

1. Go to [GitHub](https://github.com) and log in to your account.
2. Click on **New** to create a new repository.
3. Name the repository `devops-24-25-1241905`.
4. Click **Create repository**.

### 2. Create the Local Folder on Your Computer

Create a local folder where your project will reside. Open a terminal and run:

```bash
mkdir ~/DevOps
cd ~/DevOps
```

### 3. Initialize the Local Repository and Create README.md

Initialize the local Git repository and create the `README.md` file:

```bash
mkdir -p DevOps/devops-24-25-1241905/CA1/part1
echo "# devops-24-25-1241905" >> DevOps/devops-24-25-1241905/CA1/README.md
git init
git add DevOps/devops-24-25-1241905/CA1/README.md
git commit -m "first commit"
```

### 4. Add the Remote Repository and Push Your Changes

Link the local repository to the remote GitHub repository and push the initial commit:

```bash
git remote add origin https://github.com/fmoreira13/devops24-25-1241905.git
git branch -M main
git push -u origin main
```

---

## Cloning the Tutorial Repository and Organizing the Structure

### 5. Clone the React.js and Spring Data REST Tutorial Repository

Clone the tutorial repository at https://github.com/spring-attic/tut-react-and-spring-data-rest :

```bash
mkdir ~/git-tutorial
cd ~/git-tutorial
git clone https://github.com/fmoreira13/tutorial-reactjs-spring-data-rest.git
```


### 8. Move the `basic` Folder to `part1`

Move the `basic` directory (from the cloned tutorial repository) into the `part1` folder:

```bash
mv ~/git-tutorial/tut-react-and-spring-data-rest/basic ~/DevOps/devops-24-25-1241905/CA1/part1/
```

Don't forget copy the global `pom.xml` from the cloned repository to the `part1` directory:

```bash
cp ~/git-tutorial/tut-react-and-spring-data-rest/pom.xml ~/DevOps/devops-24-25-1241905/CA1/part1/
```

The global pom.xml is located at the root of the cloned repository. You need to copy it to the `part1` directory so that the global dependencies and configurations are properly applied.

### 7. Create the `.gitignore` File

In the `part1` directory, create a `.gitignore` file to exclude unnecessary files from being tracked by Git. Here is a basic `.gitignore`:

```
node_modules/
*.log
*.env
```
### 9. Create Tag `v1.1.0`

After organizing your files, create a version tag `v1.1.0` to mark this step:

```bash
git tag -a v1.1.0 -m "Initial setup and file organization"
```

---

## Managing Issues and Implementing Features

### 10. Install GitHub CLI (gh)

The GitHub CLI (`gh`) allows you to interact with GitHub directly from the terminal. Install it on macOS using Homebrew:

```bash
brew install gh
```

After installation, authenticate with your GitHub account:

```bash
gh auth login
```

### 11. Create an Issue on GitHub

Create an issue to add a new field (`jobYears`) to the application:

```bash
gh issue create --title "new feature to add a new field to the application" --body "add a new field to record the years of the employee in the company" --label "enhancement"
```

### 12. Add Comments to the Issue

You can add comments to the issue for further clarification. Use the following command to add a comment to issue #1:

```bash
gh issue comment 1 --body "To do this, I have to go to the Employee Class in the application src"
```

### 13. Implement the `jobYears` Field in the `Employee` Class

Add the new `jobYears` attribute to the `Employee` class and update the following methods:

- Constructor
- `equals` method
- `hashCode` method
- `toString` method
- Any other necessary methods

Also, update the `DatabaseLoader` class to handle the new `jobYears` field.

### 14. Write Unit Tests

Write unit tests for the `Employee` class to validate its functionality, particularly for handling null and empty values. Here's an example test case:

```java
    @Test
    void testEmployeeNullValues() {
        
        // Arrange
        String firstName = "John";
        String lastName = "Doe";
        String description = "Engineer";
        int jobYears = 5;
        
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> new Employee(null, lastName, description, jobYears));
        assertThrows(IllegalArgumentException.class, () -> new Employee(firstName, null, description, jobYears));
        assertThrows(IllegalArgumentException.class, () -> new Employee(firstName, lastName, null, jobYears));
    }
```

### 15. Debug with React Developer Tools

Use the React Developer Tools to debug the frontend of your application and ensure the new field (`jobYears`) is displayed correctly.

### 16. Close the Issue with a Commit

Once the task is completed and tested, commit the changes and close the issue with the following command:

```bash
git commit -m "Add other employees to show in localhost, closes #1"
```

### 17. Create Tag `v1.2.0`

Create a tag `v1.2.0` to mark the completion of the feature:

```bash
git tag -a v1.2.0 -m "Issue 1 completed: new field jobYears created and tested to the application"
```

### 18. Finalize the Assignment with Tag `ca1-part1.1`

Finally, create a tag `ca1-part1.1` to mark the completion of Part 1 of the assignment:

```bash
git tag ca1-part1.1 -m "Finalizing CA1 Part 1.1"
```

---

## Conclusion

This report documents the steps taken to complete the assignment, including setting up the repository, managing issues, implementing features, and using tags. The steps were performed in a tutorial style to ensure the process is reproducible. Each decision made during the process, such as the use of GitHub CLI for managing issues and the organization of files, was explained in detail.
