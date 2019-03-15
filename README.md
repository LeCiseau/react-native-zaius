# react-native-zaius

## Getting started

`$ npm install react-native-zaius --save`

### Manual installation

#### iOS pod

1. Add `pod 'RNZaius', :path => '../node_modules/react-native-zaius'` in your `Podfile`
2. Run `pod install`

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.leciseau.RNZaiusPackage;` to the imports at the top of the file
  - Add `new RNZaiusPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-zaius'
  	project(':react-native-zaius').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-zaius/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-zaius')
  	```

## Usage
```javascript
import Zaius from 'react-native-zaius';

// TODO: What to do with the module?
RNZaius;
```
