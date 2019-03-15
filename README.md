# react-native-react-native-zaius

## Getting started

`$ npm install react-native-react-native-zaius --save`

### Mostly automatic installation

`$ react-native link react-native-react-native-zaius`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-react-native-zaius` and add `RNReactNativeZaius.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNReactNativeZaius.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.leciseau.RNReactNativeZaiusPackage;` to the imports at the top of the file
  - Add `new RNReactNativeZaiusPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-react-native-zaius'
  	project(':react-native-react-native-zaius').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-react-native-zaius/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-react-native-zaius')
  	```

## Usage
```javascript
import RNReactNativeZaius from 'react-native-react-native-zaius';

// TODO: What to do with the module?
RNReactNativeZaius;
```
