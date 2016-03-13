package techreborn.compat.jei.alloySmelter;

import javax.annotation.Nonnull;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IDrawableAnimated;
import mezz.jei.api.gui.IDrawableStatic;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.recipe.BlankRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.util.StatCollector;
import techreborn.client.gui.GuiAlloySmelter;
import techreborn.compat.jei.RecipeCategoryUids;
import techreborn.compat.jei.RecipeUtil;

public class AlloySmelterRecipeCategory extends BlankRecipeCategory {
	private static final int[] INPUT_SLOTS = {0, 1};
	private static final int[] OUTPUT_SLOTS = {2};

	private final IDrawable background;
	private final IDrawableAnimated electricity;
	private final String title;

	public AlloySmelterRecipeCategory(IGuiHelper guiHelper) {
		background = guiHelper.createDrawable(GuiAlloySmelter.texture, 46, 16, 91, 54);
		IDrawableStatic electricityDrawable = guiHelper.createDrawable(GuiAlloySmelter.texture, 176, 0, 14, 14);
		electricity = guiHelper.createAnimatedDrawable(electricityDrawable, 300, IDrawableAnimated.StartDirection.TOP, true);
		title = StatCollector.translateToLocal("techreborn.jei.category.alloy.furnace");
	}

	@Nonnull
	@Override
	public String getUid() {
		return RecipeCategoryUids.ALLOY_SMELTER;
	}

	@Nonnull
	@Override
	public String getTitle() {
		return title;
	}

	@Nonnull
	@Override
	public IDrawable getBackground() {
		return background;
	}

	@Override
	public void drawAnimations(@Nonnull Minecraft minecraft) {
		electricity.draw(minecraft, 10, 20);
	}

	@Override
	public void setRecipe(@Nonnull IRecipeLayout recipeLayout, @Nonnull IRecipeWrapper recipeWrapper) {
		IGuiItemStackGroup guiItemStacks = recipeLayout.getItemStacks();
		guiItemStacks.init(INPUT_SLOTS[0], true, 0, 0);
		guiItemStacks.init(INPUT_SLOTS[1], true, 18, 0);
		guiItemStacks.init(OUTPUT_SLOTS[0], false, 69, 18);

		if (recipeWrapper instanceof AlloySmelterRecipeWrapper) {
			AlloySmelterRecipeWrapper recipe = (AlloySmelterRecipeWrapper) recipeWrapper;
			RecipeUtil.setRecipeItems(recipeLayout, recipe, INPUT_SLOTS, OUTPUT_SLOTS, null, null);
		}
	}
}