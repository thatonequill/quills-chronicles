package com.quill.epilogue.inkwell.recipe;

import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class InkwellRecipes {
    public static final RecipeSerializer<DustingRecipe> DUSTING_SERIALIZER = Registry.register(
            Registries.RECIPE_SERIALIZER, Identifier.of("inkwell", "dusting"), new DustingRecipe.Serializer());

    public static final RecipeType<DustingRecipe> DUSTING_TYPE = Registry.register(
            Registries.RECIPE_TYPE, Identifier.of("inkwell", "dusting"), new RecipeType<>() {
                @Override
                public String toString() {
                    return "dusting";
                }
            });

    public static void initialize() {}
}