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
package gay.sylv.wij.impl.network.s2c

import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.Blocks
import net.minecraft.network.PacketByteBuf
import net.minecraft.network.listener.ClientPlayPacketListener
import net.minecraft.network.packet.Packet
import net.minecraft.util.math.BlockPos
import net.minecraft.world.chunk.palette.PalettedContainer

/**
 * Signals that a chunk (entire size of jar) has updated. This sends the [BlockPos] of the jar as well as the [PalettedContainer]<[BlockState]> of the chunk.
 */
class JarWorldChunkUpdateS2CPacket(val pos: BlockPos, val blockStateContainer: PalettedContainer<BlockState>) : Packet<ClientPlayPacketListener> {
	constructor(buf: PacketByteBuf) : this(buf.readBlockPos(), buf.run {
		val container = PalettedContainer(Block.STATE_IDS, Blocks.AIR.defaultState, PalettedContainer.PaletteProvider.BLOCK_STATE)
		container.readPacket(this@run)
		container
	})
	
	override fun write(buf: PacketByteBuf) {
		buf.writeBlockPos(pos)
		blockStateContainer.writePacket(buf)
	}
	
	override fun apply(listener: ClientPlayPacketListener) {
	}
}
