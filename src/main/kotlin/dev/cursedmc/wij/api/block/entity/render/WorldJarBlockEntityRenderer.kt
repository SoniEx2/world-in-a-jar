package dev.cursedmc.wij.api.block.entity.render

import dev.cursedmc.wij.api.block.entity.WorldJarBlockEntity
import dev.cursedmc.wij.impl.scale
import net.minecraft.client.MinecraftClient
import net.minecraft.client.render.RenderLayers
import net.minecraft.client.render.VertexConsumerProvider
import net.minecraft.client.render.block.entity.BlockEntityRenderer
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.util.math.BlockPos
import net.minecraft.util.random.RandomGenerator

open class WorldJarBlockEntityRenderer(private val ctx: BlockEntityRendererFactory.Context) : BlockEntityRenderer<WorldJarBlockEntity> {
	override fun render(
		entity: WorldJarBlockEntity,
		tickDelta: Float,
		matrices: MatrixStack,
		vertexConsumers: VertexConsumerProvider?,
		light: Int,
		overlay: Int
	) {
		val max = entity.magnitude - 1
		
		matrices.scale(entity.scale)
		matrices.translate(0.0, 1.0, 0.0)
		
		// todo: build a VBO (VertexBuffer Object) and upload that shit to the GPU for rendering
		// THE MODFEST IS IN 3 MINUTES HELP WHY WON'T IT UPLOAD PLEASE
		
		for (x in 0..max) {
			for (y in 0 until max) {
				for (z in 0..max) {
					matrices.push()
					
					// prevent z-fighting
					if (x == 0) matrices.translate(0.001, 0.0, 0.0) else if (x == max) matrices.translate(-0.001, 0.0 ,0.0)
					if (y == max - 1) matrices.translate(0.0, -0.001, 0.0)
					if (z == 0) matrices.translate(0.0, 0.0, 0.001) else if (z == max) matrices.translate(0.0, 0.0, -0.001)
					
					// translate to position
					matrices.translate(x.toDouble(), y.toDouble(), z.toDouble())
					
					val pos = BlockPos.Mutable(x, y, z).add(entity.subPos)
					val state = entity.subworld?.getBlockState(pos)
					
					ctx.renderManager.renderBlockAsEntity(state, matrices, vertexConsumers, light, overlay)
					matrices.pop()
				}
			}
		}
	}
}
