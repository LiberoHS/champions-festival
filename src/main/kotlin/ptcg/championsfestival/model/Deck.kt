package ptcg.championsfestival.model

import java.net.URI

data class Deck(
    val deckId: Int,
    val archetype: String,
    val assets: Set<PokemonAsset>,
)

data class PokemonAsset(
    val pokemon: String,
    val shuffleAsset: URI,
    val pixelAsset: URI
)