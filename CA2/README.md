# DevOps Assignment - CA1

**Author:** Fernando Moreira

**Date:** 24/02/2025

**Discipline:** DevOps

**Program:** SWitCH DEV

**Institution:** ISEP - Instituto Superior de Engenharia do Porto

## Table of Contents

- [Introduction](#introduction)
- [Part 1: Virtualization With VirtualBox ](#part-1-virtualization-with-virtualbox)


## Introduction

This first part of the CA2 assignment focuses on practicing with VirtualBox by running previously developed projects inside a virtualized Ubuntu Server environment. The objective is to simulate real-world deployment scenarios by recreating a working development environment from scratch within a VM. This involves creating the virtual machine, cloning the individual GitHub repository, installing all necessary dependencies, and attempting to build and run the spring-boot-tutorial and gradle_basic_demo projects. Furthermore, networked applications such as web services and client-server chat systems are tested across the VM (acting as a server) and the host machine (acting as client or browser). Throughout this process, any issues encountered and their resolutions are documented. The final goal is to gain hands-on experience with software development in isolated, reproducible environments.

## Part 1: Virtualization with VirturalBox

### Create a Virtual Machine (VM)

- I began by downloading VirtualBox from https://www.virtualbox.org/wiki/Downloads and proceeding with its installation.

- After launching VirtualBox, I selected "New" to create a virtual machine. I assigned a name to the VM and chose the corresponding operating system type and version.

- I allocated 4096 MB of RAM to the virtual machine for stable performance and created a virtual hard disk to store system files and data.

- Within the VM’s configuration menu, I accessed the Storage tab and linked the ISO image of the Ubuntu minimal installation to the optical drive. I then booted up the VM and completed the OS installation by following the step-by-step instructions.

![des](imagens/vm-4096.png)
- 
- Once the system was set up, I installed the VirtualBox Guest Additions to enhance compatibility and functionality.

- To prepare the environment, I configured the VM for an Ubuntu 24.04.2 minimal system. The network setup included two adapters: the first one used NAT mode to enable internet access, and the second was configured as a Host-Only Adapter (vboxnet0) to allow direct communication between the VM and the host computer.

![des](imagens/vm-host.png)
![des](imagens/vm-home.png)

### Network Configuration

After completing the initial setup of the virtual machine, I proceeded to configure the network and key services to improve the VM's usability and connectivity.

- I navigated to the VirtualBox main menu and opened the **Host Network Manager** by going to `File` -> `Tools` ->  `Network Manager`.
- By clicking the `Create` button, I added a new **Host-only Network**, which appeared in the list. This step enabled me to define a network name later within the VM’s network settings.
- With the **Host-only Adapter** (vboxnet0) in place, I reviewed the subnet range, which was `192.168.56.5/24`. I manually selected `192.168.56.1` as the static IP for the VM's secondary network adapter, ensuring it was part of the correct subnet.
- Once the VM was running, I updated the system's package list using `sudo apt update`.
- To support network configurations, I installed the necessary utilities via `sudo apt install net-tools`.
- I configured the second network interface with the static IP by editing the Netplan file: `sudo nano /etc/netplan/01-netcfg.yaml`. The file was updated to the following content:

```yaml
network:
  version: 2
  renderer: networkd
  ethernets:
    enp0s3:
      dhcp4: yes
    enp0s8:
      addresses:
        - 192.168.56.5/24
```

After saving the configuration, I executed sudo netplan apply to implement the changes.

To enable remote access, I installed the OpenSSH server with sudo apt install openssh-server. Then, I modified /etc/ssh/sshd_config to allow password-based logins by uncommenting the line PasswordAuthentication yes. The SSH service was restarted using sudo service ssh restart.

For file transfer capabilities, I installed an FTP server by running sudo apt install vsftpd. I enabled file writing by modifying the configuration file /etc/vsftpd.conf, ensuring the line write_enable=YES was uncommented. The changes took effect after restarting the service with sudo service vsftpd restart.

### Install Project Dependencies

Once the virtual machine was properly configured and network access was confirmed, I proceeded to install the essential development tools needed for Java-based projects.

I started by ensuring the system was fully updated. This included refreshing the list of available packages and applying any pending upgrades with the following commands:

```bash
sudo apt update
sudo apt upgrade
```

With the system up-to-date, I installed `Git`, which is crucial for version control and source code collaboration:
```bash
sudo apt install git
```

To support Java development, I added both the Java Development Kit `JDK` and the Java Runtime Environment `JRE` to the system:
```bash
sudo apt install openjdk-17-jdk openjdk-17-jre
```

Next, I installed `Maven`, which handles project dependencies and automates the build process for Java applications:
```bash
sudo apt install maven
```

Installing `Gradle` required a few additional steps since it wasn't directly available in the preferred version through the package manager:
```bash
wget https://services.gradle.org/distributions/gradle-8.7-bin.zip
sudo mkdir /opt/gradle
sudo unzip -d /opt/gradle gradle-8.7-bin.zip
```

At this point, the virtual machine was fully equipped with the necessary tools to compile, build, and run Java projects.

Finally, I verified the installation and functionality of each tool by checking their versions:
```bash
git --version
java --version
mvn --version
gradle --version
```

### Cloning the Repository

To bring my personal repository into the virtual machine, I first needed to establish a secure SSH connection between the VM and GitHub. Below are the steps I followed:

I began by creating a new SSH key pair on the virtual machine to enable secure interactions with GitHub. This was done via the terminal with the command:

```bash
ssh-keygen -t ed25519 -C "myemail@example.com"
```

Once the key pair was generated, I needed to associate the public key with my GitHub account. I displayed the contents of the public key file using:
```bash
cat ~/.ssh/id_ed25519.pub
```

After copying the key, I signed in to GitHub, went to Settings > SSH and GPG keys, clicked on New SSH key, and pasted the key into the input field before saving it. This step authorized the VM to communicate securely with GitHub.

With SSH access in place, I proceeded to clone the repository directly into a chosen folder within the VM by executing:
git clone https://github.com/fmoreira13/devops-24-25-1241905.git

This successfully downloaded my repository onto the virtual machine, making it ready for development or further configuration.












