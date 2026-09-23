package com.quill.epilogue.inkwell.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public class DustingRecipe implements Recipe<DustingRecipeInput> {
    private final DefaultedList<Ingredient> inputs;
    private final ItemStack output;

    public DustingRecipe(DefaultedList<Ingredient> inputs, ItemStack output) {
        this.inputs = inputs;
        this.output = output;
    }

    public DefaultedList<Ingredient> getInputs() {
        return inputs;
    }

    public ItemStack getRawOutput() {
        return output;
    }

    @Override
    public boolean matches(DustingRecipeInput input, World world) {
        if (world.isClient()) return false;
        
        java.util.List<ItemStack> provided = new java.util.ArrayList<>();
        for (int i = 0; i < input.getSize(); i++) {
            ItemStack stack = input.getStackInSlot(i);
            if (!stack.isEmpty()) {
                provided.add(stack);
            }
        }
        
        // The grid must contain the exact number of items the recipe requires
        if (provided.size() != inputs.size()) return false;
        
        for (Ingredient ingredient : inputs) {
            boolean found = false;
            for (int i = 0; i < provided.size(); i++) {
                if (ingredient.test(provided.get(i))) {
                    provided.remove(i);
                    found = true;
                    break;
                }
            }
            if (!found) return false;
        }
        
        return provided.isEmpty();
    }

    @Override
    public ItemStack craft(DustingRecipeInput input, RegistryWrapper.WrapperLookup lookup) {
        return output.copy();
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResult(RegistryWrapper.WrapperLookup lookup) {
        return output;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return InkwellRecipes.DUSTING_SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return InkwellRecipes.DUSTING_TYPE;
    }

    public static class Serializer implements RecipeSerializer<DustingRecipe> {
        public static final MapCodec<DustingRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.DISALLOW_EMPTY_CODEC.listOf().fieldOf("ingredients").flatXmap(
                        ingredients -> {
                            Ingredient[] array = ingredients.toArray(Ingredient[]::new);
                            if (array.length == 0 || array.length > 4) {
                                return com.mojang.serialization.DataResult.error(() -> "Dusting recipe must have between 1 and 4 ingredients");
                            }
                            return com.mojang.serialization.DataResult.success(DefaultedList.copyOf(Ingredient.EMPTY, array));
                        },
                        list -> com.mojang.serialization.DataResult.success(list) // Fixed: Wraps return in DataResult
                ).forGetter(DustingRecipe::getInputs),
                ItemStack.CODEC.fieldOf("result").forGetter(DustingRecipe::getRawOutput) // Fixed: Uses Getter
        ).apply(inst, DustingRecipe::new));

        public static final PacketCodec<RegistryByteBuf, DustingRecipe> PACKET_CODEC = PacketCodec.tuple(
                Ingredient.PACKET_CODEC.collect(PacketCodecs.toList()), DustingRecipe::getInputs,
                ItemStack.PACKET_CODEC, DustingRecipe::getRawOutput,
                (inputs, output) -> new DustingRecipe(DefaultedList.copyOf(Ingredient.EMPTY, inputs.toArray(Ingredient[]::new)), output)
        );

        @Override
        public MapCodec<DustingRecipe> codec() { return CODEC; }

        @Override
        public PacketCodec<RegistryByteBuf, DustingRecipe> packetCodec() { return PACKET_CODEC; }
    }
}