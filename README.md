### steps
1. clonar repo java client: https://github.com/appium/java-client
2. abrir repo java client como proyecto en Android Studio.
3. en Android Studio: create device (seleccionar un system image, por ejemplo tiramisu)
   > importante incluir en el path (.zshrc) el android sdk:
   > ```
   > export ANDROID_HOME=~/Library/Android/sdk
   > PATH=$PATH:$ANDROID_HOME/tools:$ANDROID_HOME/tools/bin:$ANDROID_HOME/platform-tools
   > export PATH
   > export ANDROID_HOME=~/Library/Android/sdk
   > export ANDROID_SDK_ROOT=~/Library/Android/sdk
   > export ANDROID_AVD_HOME=~/.android/avd
   > ```
4. instalar las dependencias de appium: ``npm install -g appium``
5. instalar el controlador UIAutomator2: ``npx appium driver install uiautomator2``
6. mantener el servidor appium levantado: ``npx appium``
7. testamos esta apk!! -> https://github.com/saucelabs/my-demo-app-rn/releases (Android-MyDemoAppRN.1.3.0.build-244.apk)
8. nuevo proyecto maven en una IDE aparte (already done in this repo)
9. agregar las siguientes dependencias (already done in this repo)
    ```
   <dependencies>
        <!-- https://mvnrepository.com/artifact/io.appium/java-client -->
        <dependency>
            <groupId>io.appium</groupId>
            <artifactId>java-client</artifactId>
            <version>8.5.1</version>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-api</artifactId>
            <version>5.10.0</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-engine</artifactId>
            <version>5.10.0</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>ch.qos.logback</groupId>
            <artifactId>logback-classic</artifactId>
            <version>1.4.11</version> <!-- Use the latest version -->
        </dependency>
    </dependencies>
   ```
9. Script SauceLabsTest de este repo:
   > la capability "deviceName" se puede encontrar en la terminal con el comando ``adb devices``.
   > 
   > nótese que la capability "app" contiene la ruta de la apk a testear.
   > 
   > The default server port for Appium is 4723. 
   > 
   > AndroidDriver creates a new instance based on capabilities.
10. :white_check_mark: la apk aparece en el simulador del android studio
11. :white_check_mark: la apk aparece en appium inspector
12. run test SauceLabsTest
13. :white_check_mark: tests passed
