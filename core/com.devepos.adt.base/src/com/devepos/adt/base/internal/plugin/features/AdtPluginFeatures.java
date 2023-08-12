package com.devepos.adt.base.internal.plugin.features;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.Assert;

import com.devepos.adt.base.model.adtbase.IAdtPluginFeature;
import com.devepos.adt.base.plugin.features.IAdtPluginFeatures;

public class AdtPluginFeatures implements IAdtPluginFeatures {

  private final Map<String, IAdtPluginFeature> nameToFeature;

  public AdtPluginFeatures(final List<IAdtPluginFeature> features) {
    Assert.isTrue(features != null && !features.isEmpty());
    nameToFeature = features.stream()
        .collect(Collectors.toMap(IAdtPluginFeature::getName, Function.identity()));
  }

  @Override
  public boolean areAllFeaturesEnabled() {
    return nameToFeature.values().stream().allMatch(IAdtPluginFeature::isEnabled);
  }

  @Override
  public IAdtPluginFeature[] getAll() {
    return nameToFeature.values().toArray(new IAdtPluginFeature[nameToFeature.size()]);
  }

  @Override
  public IAdtPluginFeature getFeature(final String name) {
    return nameToFeature.get(name);
  }

  @Override
  public boolean isFeatureEnabled(final String name) {
    IAdtPluginFeature feature = nameToFeature.get(name);
    return feature != null ? feature.isEnabled() : false;
  }

}
