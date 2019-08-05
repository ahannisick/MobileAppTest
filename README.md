Appium & Xcode Setup for iOS:

Step 1: Installed Homebrew

/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"

Step 2: Installed Node.js

brew install node

node -v (v12.7.0)
/usr/local/bin/node

npm -v (6.10.0) 
/usr/local/bin/npm
Step 3: Installed Appium using Node.js Also installed the Desktop Client Desktop Client (UI Application for Appium) - .dmg file http://appium.io/ https://github.com/appium/appium-desktop

npm install -g appium
to install a specific version ex:
npm install -g appium@1.13.1

appium —version (1.14.1)
/usr/local/bin/appium

Start Appium:
appium
[Appium] Welcome to Appium v1.14.1
[Appium] Appium REST http interface listener started on 0.0.0.0:4723
Step 4: Installed Appium Doctor.

npm install appium-doctor -g
appium-doctor —version (1.11.1)
/usr/local/bin/appium-doctor
https://github.com/appium/appium-doctor


appium-doctor -h
appium-doctor -v
appium-doctor —ios

Uninstall Instructions:

If installed through node.js
npm uninstall -g appium

If installed Appium Desktop Client
Delete app
Step 5: Manually Installed Xcode from App Store

Set the default Xcode path:
sudo xcode-select -s /Applications/Xcode.app/Contents/Developer

Check if Xcode is installed:
xcode-select --version
xcode-select -p (checks if command line tools are installed)

Run Appium Doctor for IOS:
appium-doctor —ios

Launch XCode
Xcode - Preferences - Accounts - Create/Link Apple ID
Step 6: Installed Carthage (required to launch WebDriverAgent) https://github.com/Carthage/Carthage

brew install Carthage
carthage version
which Carthage
/usr/local/bin/Carthage
Step 7: Initialized WebDriverAgent project

cd /usr/local/lib/node_modules/appium/node_modules/appium-xcuitest-driver/WebDriverAgent
mkdir -p Resources/WebDriverAgent.bundle
./Scripts/bootstrap.sh -d
Note: this command needs Carthage to be installed
Step 8: Open WebDriverAgent.xcodeproj in Xcode

Navigate to project location:
/Applications/Appium.app/Contents/Resources/app/node_modules/appium/node_modules/appium-xcuitest-driver/WebDriverAgent

Find “WebDriverAgent.xcodeproj”

Right Click - Open With Xcode.app

In Xcode, check for any Builtime/Runtime Issues (!) and resolve them

Migrate “English.lproj” (Deprecated)
Migrating the English, deprecated localization to English is recommended for all projects. This will ensure localized resources are placed in “en.lproj” directories instead of deprecated “English.lproj” directories.
Step 9: Under the project in Xcode, configured the following:

For WebDriverAgentLib and WebDriverAgentRunner targets, go to general tab and select "Automatically manage signing"
Enable Automatic (Xcode will automatically create and update profiles, app  ID’s, and certificates
Then select your Development Team

Xcode may fail to create a provisioning profile for the WebDriverAgentRunner target:

Failed to create provisioning profile
No profile for ‘…..’ were found

manually change the bundle id for the target by going into the "Build Settings" tab, and changing the "Product Bundle Identifier" under “Packaging”  from com.facebook.WebDriverAgentRunner to something that   Xcode will accept:

Go back to the "General" tab for the WebDriverAgentRunner target, you should now see that it has created a provisioning profile and all is well:

Product - Clean - Build - Run (shift + command + k)

Verify Everything Works By Building the Project:
Step 10: Verify everything works by building the project:

Navigate to WebDriverAgent directory:
cd /Applications/Appium.app/Contents/Resources/app/node_modules/appium/node_modules/appium-xcuitest-driver/WebDriverAgent

Build from source. This will build ios-deploy into the build/Release folder:
xcodebuild

cd /Applications/Appium.app/Contents/Resources/app/node_modules/appium/node_modules/appium-xcuitest-driver/WebDriverAgent

xcodebuild -project WebDriverAgent.xcodeproj -scheme WebDriverAgentRunner -destination 'id=<udid>' test

To View Mobile Device ID’s in Terminal:
//Install ios-deploy (using node.js package manager)
        npm install -g ios-deploy
        ios-deploy -c

View Simulators:
    instruments -s devices

View Real Devices:
    ios-deploy -c
Step 10: Installed Apache Maven

Step 11: Installed Java JDK

Check if Java is installed:
java -version (checks java version)
javac -version (checks java compiler version)

//make sure homebrew is installed
Install cask:
brew tap caskroom/cask

The older Oracle JDKs are gone from Homebrew now. Use OpenJDK instead:

brew tap adoptopenjdk/openjdk
brew cask install adoptopenjdk9

To Upgrade Java:
brew cask upgrade adoptopenjdk9

To Uninstall Java:
brew cask uninstall caskroom/versions/adoptopenjdk8

Java Home Directory:
/Library/Java/JavaVirtualMachines/adoptopenjdk-9.jdk/Contents/Home

nano ~/.bash_profile
export JAVA_HOME=/Library/Java/JavaVirtualMachines/adoptopenjdk-9.jdk/Contents/$
export PATH=$JAVA_HOME/bin:$PATH
Step 12: Installed IntelliJ - Created New Maven Project - Configured SDK

Step 13: Added Required Libraries / Dependencies

Appium Java Client:
https://mvnrepository.com/artifact/io.appium/java-client
Select the latest (non beta) version of Appium Java Client
Copy / Paste Maven Dependencies into Pom.xml

Selenium Java:
https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java
Select the latest (non beta) version of Selenium Java
Copy / Paste Maven Dependencies into Pom.xml

TestNG:
https://mvnrepository.com/artifact/org.testng/testng
Select the latest (non beta) version of TestNG
Copy / Paste Maven Dependencies into Pom.xml
Additional EXTERNAL TOOLS/UTILITIES:

To deploy our apps to our devices. We can install and debug apps from the command line without using Xcode

ideviceinstaller version “1.1.0_4” 
/usr/local/bin/ideviceinstaller
sudo xcode-select -r
brew install ideviceinstaller

ios-deploy version “1.9.4”
/usr/local/bin/ios-deploy

See UDID’s for Devices in Terminal:
npm install -g ios-deploy
ios-deploy -c

Simulators:
instruments -s devices

ios-webkit-debug-proxy version “1.8.5”
/usr/local/Cellar/ios-webkit-debug-proxy/1.8.5:
In order to access web views on real iOS devices, we need to install this tool

authorize-ios version “”
a utility which pre-authorizes to run UIAutomation scripts on iOS devices.

libimobiledevice version “”

A cross-platform protocol library to communicate with iOS devices.
VERSIONS:

node version “v12.7.0”
/usr/local/bin/node
    node -v
    which node

npm version “6.10.0”
/usr/local/bin/npm
    npm -v 
    which npm

appium version “1.14.1”
/usr/local/bin/appium
    appium —version 
    which appium

appium doctor version “1.11.1”
/usr/local/bin/appium-doctor
    appium-doctor —version
    which appium-doctor

xcode version “10.3” (10G8) | xcode-select version 2354
/Applications/Xcode.app/Contents/Developer
    xcode-select --version
    xcode-select -p (checks if command line tools are installed)

carthage version “0.33.0” 
/usr/local/bin/Carthage
    which carthage
    carthage version

java openjdk version “9” | javac 9
/Library/Java/JavaVirtualMachines/adoptopenjdk-9.jdk/Contents/Home
    java -version
    javac -version (compiler)

As of April 16th, 2019 Oracle has significantly changed the way they license their versions of the JDK. In order to install a JDK version (>1.8 or <10.x) I had to install the openjdk version because older archived versions require an oracle account. Oracle account creation requires specific fields  including current employer information of which I am not eligible to complete at this time.
apache maven version “3.6.1”



