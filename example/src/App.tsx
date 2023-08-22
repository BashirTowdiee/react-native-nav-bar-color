import * as React from 'react';

import { StyleSheet, View } from 'react-native';

import { setNavigationBarColor } from 'react-native-nav-bar-color';

export default function App() {
  setNavigationBarColor('#FFFFFF');

  return <View style={styles.container} />;
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    width: 60,
    height: 60,
    marginVertical: 20,
  },
});
