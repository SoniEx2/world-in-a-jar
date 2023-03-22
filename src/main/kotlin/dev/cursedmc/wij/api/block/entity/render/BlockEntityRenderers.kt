/**
 * Copyright (c) 2022 CursedMC. All rights reserved.
 *
 * World In A Jar is common software: you can redistribute it and/or modify it under the terms of the Commons Protection License as published by the Revolutionary Technical Committee.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the Commons Protection License for more details.
 */
package dev.cursedmc.wij.api.block.entity.render

import dev.cursedmc.wij.api.Initializable
import dev.cursedmc.wij.api.block.entity.BlockEntityTypes
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories

object BlockEntityRenderers : Initializable {
	init {
		BlockEntityRendererFactories.register(
			BlockEntityTypes.WORLD_JAR,
			::WorldJarBlockEntityRenderer,
		)
	}
}
