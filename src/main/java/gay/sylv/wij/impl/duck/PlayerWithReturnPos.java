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
package gay.sylv.wij.impl.duck;

import net.minecraft.util.math.Vec3d;

// todo create api
/**
 * Holds a return position. A mixin implements this interface on all {@link net.minecraft.entity.player.PlayerEntity}s.
 */
@SuppressWarnings("unused")
public interface PlayerWithReturnPos {
	Vec3d worldinajar$getReturnPos();
	void worldinajar$setReturnPos(Vec3d returnPos);
}
