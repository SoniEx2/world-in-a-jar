/**
 * Copyright (c) 2022 CursedMC. All rights reserved.
 *
 * World In A Jar is common software: you can redistribute it and/or modify it under the terms of the Commons Protection License as published by the Revolutionary Technical Committee.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the Commons Protection License for more details.
 */
@file:Suppress("unused")
package gay.sylv.wij.impl.client

import gay.sylv.wij.impl.block.Blocks
import gay.sylv.wij.impl.block.entity.render.BlockEntityRenderers
import gay.sylv.wij.impl.network.s2c.S2CPackets
import net.minecraft.client.render.RenderLayer
import org.quiltmc.loader.api.ModContainer
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer
import org.quiltmc.qsl.block.extensions.api.client.BlockRenderLayerMap

class WorldInAJarClient : ClientModInitializer {
	override fun onInitializeClient(mod: ModContainer?) {
		S2CPackets.initialize()
		
		BlockEntityRenderers.initialize()
		
		BlockRenderLayerMap.put(RenderLayer.getTranslucent(), Blocks.WORLD_JAR)
	}
}
