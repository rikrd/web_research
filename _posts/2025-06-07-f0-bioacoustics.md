---
layout: post
title: "Benchmarking Neural F0 Estimation for Bioacoustics"
description: "Transferring MIR tools to animal vocalisation analysis"
permalink: /f0-bioacoustics/
---

> 📄 **Full paper (Author Accepted Manuscript):**  
> [Download PDF](/assets/f0-examples/Accepted_Manuscript_Best_Marxer_et_al_2025.pdf)


## 🧠 Overview

The **fundamental frequency (F0)** is essential to characterising animal vocalisations, supporting studies from **individual recognition** to **population dialects**.

Yet:

- ⚠️ Manual annotation is time-consuming  
- ⚙️ Automation is complex — especially in bioacoustics

## 🔍 Motivation

While **speech and music** research has made great strides in automatic F0 tracking, **bioacoustics lags behind**. Why?

- Extreme **variation** in signal properties (frequency, harmonicity, SNR)  
- Presence of **non-linear phenomena**

## 📦 Our Contribution

To close this gap, we introduce:

- 📊 A **benchmark dataset** of over **250,000 vocalisations** from **14 taxa**, with **ground truth F0**
- 🐦 A diversity of signals: infra- to ultra-sound, high to low harmonicity
- 🤖 A **benchmark of F0 estimation algorithms**, including deep learning models

## 🧬 Key Findings

- ✅ Neural networks can **generalise** to:
  - Species not seen during training  
  - **Unlabeled data**, via self-supervision

- 🧠 **Self-supervised models** can perform nearly as well as supervised ones

- 📈 We propose spectral quality metrics that **correlate with F0 tracking performance**

## 🔊 Example Visualisations & Audio

**Wolf howl**  
<div style="max-width: 600px; margin: 0 auto; text-align: center;">
  <img src="/assets/f0-examples/test_wolf.png" alt="Wolf spectrogram" style="width: 100%; border: none; box-shadow: none;" />
  <audio controls style="width: 100%; margin-top: 0.5em;">
    <source src="/assets/f0-examples/test_wolf.wav" type="audio/wav">
    Your browser does not support the audio element.
  </audio>
</div>

**Réunion grey white-eye (slowed x5)**  
<div style="max-width: 600px; margin: 0 auto; text-align: center;">
  <img src="/assets/f0-examples/test_reunion_grey.png" alt="Réunion grey white-eye spectrogram" style="width: 100%; border: none; box-shadow: none;"  />
  <audio controls style="width: 100%; margin-top: 0.5em;">
    <source src="/assets/f0-examples/test_reunion_grey_slowedx5.wav" type="audio/wav">
    Your browser does not support the audio element.
  </audio>
</div>

**Bat echolocation (slowed x20)**  
<div style="max-width: 600px; margin: 0 auto; text-align: center;">
  <img src="/assets/f0-examples/test_bat.png" alt="Bat echolocation spectrogram" style="width: 100%; border: none; box-shadow: none;" />
  <audio controls style="width: 100%; margin-top: 0.5em;">
    <source src="/assets/f0-examples/test_bat_slowedx20.wav" type="audio/wav">
    Your browser does not support the audio element.
  </audio>
</div>

## 🛠️ Resources

- 📂 **Dataset**:  
  [Dryad Repository – 250k Vocalisations, 14 Taxa](https://datadryad.org/dataset/doi:10.5061/dryad.prr4xgxw8)

- 💻 **Code & Pretrained Models**:  
  [GitHub – mim-team/bioacoustic_F0_estimation](https://github.com/mim-team/bioacoustic_F0_estimation)

## 🌍 Broader Impact

This study is the **first large-scale adaptation of Music Information Retrieval (MIR) tools** to the rich, complex world of **bioacoustic signals**.

While no model is perfect, our work shows that **deep learning** offers a promising path toward **generic, scalable, and reliable F0 estimation in bioacoustics**.

🔗 **Read the full article**:  
["Benchmarking Neural F0 Estimation for Bioacoustics"](https://www.tandfonline.com/doi/full/10.1080/09524622.2025.2500380)  
Published in *Bioacoustics: The International Journal of Animal Sound and its Recording* (2025)

## 📚 How to Cite
If you use this work in your research, please cite:

```bibtex
@article{Best02062025,
  author = {Paul Best and Marcelo Araya-Salas and Axel G. Ekström and Bárbara Freitas and Frants H. Jensen and Arik Kershenbaum and Adriano R. Lameira and Kenna D. S. Lehmann and Pavel Linhart and Robert C. Liu and Malavika Madhavan and Andrew Markham and Marie A. Roch and Holly Root-Gutteridge and Martin Šálek and Grace Smith-Vidaurre and Ariana Strandburg-Peshkin and Megan R. Warren and Matthew Wijers and Ricard Marxer},
  title = {Bioacoustic fundamental frequency estimation: a cross-species dataset and deep learning baseline},
  journal = {Bioacoustics},
  volume = {0},
  number = {0},
  pages = {1--28},
  year = {2025},
  publisher = {Taylor & Francis},
  doi = {10.1080/09524622.2025.2500380},
  URL = {https://doi.org/10.1080/09524622.2025.2500380},
  eprint = {https://doi.org/10.1080/09524622.2025.2500380}
}
```