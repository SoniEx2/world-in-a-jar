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
package gay.sylv.wij.impl.plugin.wthit

import gay.sylv.wij.impl.block.entity.WorldJarBlockEntity
import gay.sylv.wij.impl.plugin.wthit.component.block.WorldJarBlockComponentProvider
import mcp.mobius.waila.api.IRegistrar
import mcp.mobius.waila.api.IWailaPlugin
import mcp.mobius.waila.api.TooltipPosition

@Suppress("unused")
class WorldInAJarWailaPlugin : IWailaPlugin {
	override fun register(registrar: IRegistrar) {
		registrar.addComponent(WorldJarBlockComponentProvider(), TooltipPosition.BODY, WorldJarBlockEntity::class.java)
	}
}
