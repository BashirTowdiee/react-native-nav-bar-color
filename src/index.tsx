import { NativeModules, Platform } from 'react-native';

const LINKING_ERROR =
  `The package 'react-native-nav-bar-color' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo Go\n';

const NavigationBarColor = NativeModules.NavigationBarColor
  ? NativeModules.NavigationBarColor
  : new Proxy(
      {},
      {
        get() {
          throw new Error(LINKING_ERROR);
        },
      }
    );

export function setNavigationBarColor(color: string): void {
  return NavigationBarColor.setNavigationBarColor(color);
}
