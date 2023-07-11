/**
 * World In a Jar
 * Copyright (C) 2023  Sylv
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package gay.sylv.wij.impl.block.entity.render

import com.mojang.blaze3d.vertex.VertexBuffer
import gay.sylv.wij.impl.block.entity.WorldJarBlockEntity
import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.Blocks
import net.minecraft.client.render.RenderLayer
import net.minecraft.client.render.chunk.BlockBufferBuilderStorage
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.ChunkSectionPos
import net.minecraft.world.chunk.palette.PalettedContainer
import org.quiltmc.loader.api.minecraft.ClientOnly
import java.util.function.Predicate
import java.util.stream.Collectors

/**
 * A 16x16x16 sub-chunk. This uses VBOs for rendering.
 * @param offset The position of the chunk in 3-dimensions.
 * @author sylv
 */
class JarChunkSection(offset: ChunkSectionPos, isClient: Boolean) {
	/**
	 * The bottom-south-west corner of the chunk. **Note**: This is automatically aligned to a 16x16x16 grid.
	 * @author sylv
	 */
	val origin: BlockPos
	@ClientOnly
	lateinit var buffers: BlockBufferBuilderStorage
	@ClientOnly
	lateinit var vertexBuffers: Map<RenderLayer, VertexBuffer>
	var blockStates: PalettedContainer<BlockState> = PalettedContainer(Block.STATE_IDS, Blocks.AIR.defaultState, PalettedContainer.PaletteProvider.BLOCK_STATE)
	
	/**
	 * Determines if any [BlockState]s adhere to the predicate.
	 * @author sylv
	 */
	fun hasAny(predicate: Predicate<BlockState>): Boolean {
		return blockStates.hasAny(predicate)
	}
	
	/**
	 * @return the [BlockState] at the given [BlockPos].
	 * @author sylv
	 */
	fun getBlockState(x: Int, y: Int, z: Int): BlockState {
		return blockStates[x, y, z]
	}
	
	init {
		this.origin = BlockPos(offset.multiply(16))
		if (isClient) {
			buffers = BlockBufferBuilderStorage()
			vertexBuffers = RenderLayer.getBlockLayers()
				.stream()
				.collect(
					Collectors.toMap(
						{ key: RenderLayer -> key },
						{ VertexBuffer(VertexBuffer.Usage.STATIC) }
					)
				)
		}
	}
}
