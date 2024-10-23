# Hyperledger-Fabric-Assignment
PROBLEM STATEMENT :  Afinancial institution needs to implement a blockchain-based system to manage and track assets. The system should support creating assets, updating asset values, querying the world state to read assets, and retrieving asset transaction history. The assets represent accounts with specific attributes, such as DEALERID, MSISDN, MPIN, BALANCE, STATUS, TRANSAMOUNT, TRANSTYPE, and REMARKS.The institution aims to ensure the security, transparency, and immutability of asset records, while also providing an efficient way to track and manage asset-related transactions and histories.

Level 1: Setting Up the Hyperledger Fabric Test Network
Start by preparing your environment:
Install Docker and Docker Compose to enable running the Fabric network in containers. Refer to the official documentation for installation steps.

Download the Hyperledger Fabric Samples:

Clone the Fabric Samples repository using Git:

**git clone https://github.com/hyperledger/fabric-samples**

Navigate to the First Network Sample:
After cloning, change directories into the sample project:

**cd fabric-samples/first-network**

Start the Fabric Network:
Launch the network components by running Docker Compose:

**docker-compose up -d**
