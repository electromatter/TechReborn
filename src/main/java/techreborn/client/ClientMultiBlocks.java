/*
 * This file is part of TechReborn, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2018 TechReborn
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package techreborn.client;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import reborncore.client.multiblock.Multiblock;
import techreborn.init.ModBlocks;

public class ClientMultiBlocks {

	public static Multiblock reactor;
	public static Multiblock frezzer;

	public static void init() {
		reactor = new Multiblock();
		checkCoils();

		frezzer = new Multiblock();
		checkMachine();
	}

	@Deprecated
	public static void checkCoils() {
		if ((isCoil(3, 0, 1)) && (isCoil(3, 0, 0)) && (isCoil(3, 0, 0 - 1)) && (isCoil(0 - 3, 0, 1))
			&& (isCoil(0 - 3, 0, 0)) && (isCoil(0 - 3, 0, 0 - 1)) && (isCoil(2, 0, 2)) && (isCoil(2, 0, 1))
			&& (isCoil(2, 0, 0 - 1)) && (isCoil(2, 0, 0 - 2)) && (isCoil(0 - 2, 0, 2)) && (isCoil(0 - 2, 0, 1))
			&& (isCoil(0 - 2, 0, 0 - 1)) && (isCoil(0 - 2, 0, 0 - 2)) && (isCoil(1, 0, 3)) && (isCoil(1, 0, 2))
			&& (isCoil(1, 0, 0 - 2)) && (isCoil(1, 0, 0 - 3)) && (isCoil(0 - 1, 0, 3)) && (isCoil(0 - 1, 0, 2))
			&& (isCoil(0 - 1, 0, 0 - 2)) && (isCoil(0 - 1, 0, 0 - 3)) && (isCoil(0, 0, 3)) && (isCoil(0, 0, 0 - 3))) {
		}
	}

	@Deprecated
	private static boolean isCoil(int x, int y, int z) {
		reactor.addComponent(new BlockPos(x, y, z), ModBlocks.FUSION_COIL.getDefaultState());
		return true;
	}

	public static void checkMachine() {
		int xDir = EnumFacing.UP.getFrontOffsetX() * 2;
		int yDir = EnumFacing.UP.getFrontOffsetY() * 2;
		int zDir = EnumFacing.UP.getFrontOffsetZ() * 2;
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				for (int k = -1; k < 2; k++) {
					if ((i != 0) || (j != 0) || (k != 0)) {
						BlockPos pos = new BlockPos(xDir + i, yDir + j, zDir + k);
						int meta = (((i == 0) && (j == 0) && (k != 0)) || ((i == 0) && (j != 0) && (k == 0))
							            || ((i != 0) && (j == 0) && (k == 0)) ? 2 : 1);
						frezzer.addComponent(pos, ModBlocks.MACHINE_CASINGS.getStateFromMeta(meta));
					}
				}
			}
		}
	}

}
