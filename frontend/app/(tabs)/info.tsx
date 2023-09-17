import { StyleSheet, ScrollView, Image } from 'react-native';

import { Text, View } from '../../components/Themed';
import mockData from '../../data/mockData.json';

export default function Info() {
  const product = mockData.product;

  return (
    <ScrollView style={styles.container}>
      <Text style={styles.title}>{product.name}</Text>
      <View style={styles.imgcontainer}>
        {/* <Image source={require('../../assets/images/dummyProduct.png')} style={styles.productImage} /> */}
        <Image source={{ uri: 'https://images.openfoodfacts.org/images/products/004/400/004/7009/front_en.20.400.jpg' }} style={styles.productImage} />
      </View>
      <Text style={styles.subtitle}>Ingredients:</Text>
      {product.ingredients.map((ingredient, index) => (
        <Text key={index} style={product.dangerousIngredients.includes(ingredient) ? styles.dangerousIngredient : styles.ingredient}>
          {ingredient}
        </Text>
      ))}

      <Text style={styles.subtitle}>Health Risks:</Text>
      {Object.entries(product.healthRisks).map(([ingredient, risk], index) => (
        <View key={index} style={styles.riskContainer}>
          <Text style={styles.dangerousIngredient}>{ingredient}:</Text>
          <Text style={styles.risk}>{risk}</Text>
        </View>
      ))}
      <View style={styles.spacer} />

    </ScrollView>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 20,
    // paddingBottom: 400, 
  },
  spacer: {
    height: 80,  //to account for nav bar
    backgroundColor: '#FFF', //TODO: fix the background color of this
  },
  imgcontainer: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
    padding: 20
  },
  title: {
    fontSize: 24,
    fontWeight: 'bold',
    textAlign: 'center',
    marginBottom: 20,
  },
  subtitle: {
    fontSize: 20,
    fontWeight: 'bold',
    marginTop: 15,
    marginBottom: 10,
  },
  ingredient: {
    fontSize: 16,
  },
  dangerousIngredient: {
    fontSize: 16,
    color: 'red',
  },
  riskContainer: {
    marginVertical: 8,
  },
  risk: {
    fontSize: 16,
    marginLeft: 10,
  },
  productImage: {
    width: 300,
    height: 300,
    resizeMode: 'contain',
    marginVertical: 20
  }
});