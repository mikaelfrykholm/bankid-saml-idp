<script setup lang="ts">
  import { computed } from 'vue';
  import type { SpInformation } from '@/types';

  const props = defineProps<{
    spInfo: SpInformation | null;
  }>();

  const getImage = computed(() => (props.spInfo ? props.spInfo.imageUrl : ''));
</script>

<template>
  <header>
    <div class="top-logo-container main-width">
      <img v-if="getImage" class="top-logo-dim" :src="getImage" alt="Logo" />
      <img v-else class="top-logo-dim" src="@/assets/logo.svg" alt="Logo" />
    </div>
  </header>
</template>

<style scoped>
  header {
    background: var(--header-bg-color);
    box-shadow: var(--header-shadow);
  }

  .top-logo-container {
    padding: 20px;
  }

  @media (min-width: 576px) {
    .top-logo-dim {
      height: 60px;
      width: auto;
    }
  }

  @media (max-width: 576px) {
    .top-logo-dim {
      height: 40px;
      width: auto;
    }
  }
</style>
