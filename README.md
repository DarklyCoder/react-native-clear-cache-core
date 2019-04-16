
# react-native-clear-cache

## Getting started

`$ npm install react-native-clear-cache --save`

### Mostly automatic installation

`$ react-native link react-native-clear-cache`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-clear-cache` and add `RNClearCache.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNClearCache.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.darklycoder.rn.clearcache.RNClearCachePackage;` to the imports at the top of the file
  - Add `new RNClearCachePackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-clear-cache'
  	project(':react-native-clear-cache').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-clear-cache/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-clear-cache')
  	```


## Usage
```javascript
import RNClearCache from 'react-native-clear-cache';

// TODO: What to do with the module?
RNClearCache;
```
  