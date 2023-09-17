import { StyleSheet, ScrollView, Image } from 'react-native';

import { Text, View } from '../../components/Themed';
import mockData from '../../data/mockData.json';

export default function Info() {
  const product = mockData;

  return (
    <ScrollView style={styles.container}>
      <Text style={styles.title}>{product.name}</Text>
      <Text style={styles.brand}>{product.brand}</Text>
      <View style={styles.imgcontainer}>
        <Image source={{ uri: product.image_url }} style={styles.productImage} />
      </View>

      <Text style={styles.subtitle}>Ingredients:</Text>
      {product.ingredients.map((ingredient, index) => (
        <Text
          key={index}
          style={product.dangerousIngredients.includes(ingredient.trim()) ? styles.dangerousIngredient : styles.ingredient}>
          {ingredient.trim()}
        </Text>
      ))}

      <Text style={styles.subtitle}>Health Risks:</Text>
      {Object.entries(product.healthRisks).map(([ingredient, risk], index) => (
        <View key={index} style={styles.riskContainer}>
          <Text style={styles.dangerousIngredient}>{ingredient.trim()}:</Text>
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
    padding: 15,
    backgroundColor: 'white',
  },
  title: {
    fontSize: 24,
    fontWeight: 'bold',
    textAlign: 'center',
    marginBottom: 5,
  },
  brand: {
    fontSize: 18,
    textAlign: 'center',
    marginBottom: 20,
  },
  imgcontainer: {
    alignItems: 'center',
    marginBottom: 20,
  },
  productImage: {
    width: 150,
    height: 150,
    resizeMode: 'cover',
  },
  subtitle: {
    fontSize: 20,
    fontWeight: 'bold',
    marginBottom: 10,
  },
  ingredient: {
    fontSize: 16,
    marginBottom: 5,
  },
  dangerousIngredient: {
    fontSize: 16,
    color: 'red',
    marginBottom: 5,
  },
  riskContainer: {
    marginBottom: 10,
  },
  risk: {
    fontSize: 16,
    marginTop: 3,
  },
  spacer: {
    height: 20,
  }
});