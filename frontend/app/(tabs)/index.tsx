import { StyleSheet } from 'react-native';

import FoodCamera from '../../components/FoodCamera';
import BarcodeScanner from '../../components/BarcodeScanner';
import { View } from '../../components/Themed';

export default function addFood() {
  return (
    <View style={styles.container}>
      {/* <FoodCamera /> */}
      <BarcodeScanner />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
  },
  title: {
    fontSize: 20,
    fontWeight: 'bold',
  },
  separator: {
    marginVertical: 30,
    height: 1,
    width: '80%',
  },
});

