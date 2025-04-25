---
layout: page
title: Resources
permalink: /resources/
---

### Data
#### Eiffel Tower: A Deep-Sea Underwater Dataset for Long-Term Visual Localization
   [<img style="max-width: 200px; float: right; margin: 1em; overflow: auto;" src="{{ site.baseurl }}/assets/eiffel_tower_topology.jpg">](https://sextant.ifremer.fr/record/seanoe:92226/)

[Eiffel Tower](https://sextant.ifremer.fr/record/seanoe:92226/) is a new deep-sea dataset to benchmark underwater long-term visual localization. The dataset is composed of images from four visits to the same hydrothermal vent edifice over the course of five years. Camera poses and a common geometry of the scene were estimated using navigation data and Structure-from-Motion. This serves as a reference when evaluating visual localization techniques. An analysis of the data provides insights about the major changes observed throughout the years. We have evaluated several well-established visual localization methods on the dataset, showing there is still room for improvement in underwater long-term visual localization.


#### ScribbleLens: Dutch Historical Handwritten Documents
   [<img style="max-width: 200px; float: right; margin: 1em; overflow: auto;" src="{{ site.baseurl }}/assets/scribblelens.jpg">](https://openslr.org/84/)

[ScribbleLens](https://openslr.org/84/) is a new handwritten corpus based on 400-year-old, cursive, early modern Dutch documents such as ship journals and daily logbooks. The 1000 page collection has been segmented into lines and we provide textual transcriptions on 20% of the pages. Other annotations such as handwriting slant, year of origin, complexity, and writer identity have been manually added. With over 80 writers this corpus is significantly larger and more varied than other existing data sets such as Spanish RODRIGO. We provide train/test splits, experimental results from an automatic transcription baseline and tools to facilitate its use in deep learning research. The manuscripts span over 150 years of significant journeys by captains and traders from the Vereenigde Oost-indische Company (VOC) such as Tasman, Brouwer and Van Neck, making this resource also valuable to historians and the paleography community.


#### Audio-visual Lombard speech
   [<img style="max-width: 200px; float: right; margin: 1em; overflow: auto;" src="{{ site.baseurl }}/assets/avlombardgrid.png">](http://spandh.dcs.shef.ac.uk/avlombard/)

[The audio-visual Lombard Grid speech corpus](http://spandh.dcs.shef.ac.uk/avlombard/) is a bi-view audiovisual Lombard speech corpus which can be used to support joint computational-behavioral studies in speech perception. The corpus includes 54 talkers, with 100 utterances per talker (50 Lombard and 50 plain utterances). This dataset follows the same sentence format as the audiovisual Grid corpus, and can thus be considered as an extension of that corpus. The sentence sets used in the Lombard Grid corpus are unique, however, and have not been utilized by the Grid corpus.

#### Consistent confusions
   [<img style="max-width: 200px; filter: invert(100%); float: right; margin: 1em; overflow: auto;" src="{{ site.baseurl }}/assets/consistent_confusion.png">](http://spandh.dcs.shef.ac.uk/ECCC/)

[The English Consistent Confusion Corpus](http://spandh.dcs.shef.ac.uk/ECCC/) is a large-scale collection of noise induced British English speech misperceptions. These misperceptions have been elicited by asking listeners to transcribe English words mixed with complex noise backgrounds.

### Software
#### Loudia
[<img style="max-width: 200px; float: right; margin: 1em; overflow: auto;" src="{{ site.baseurl }}/assets/loudia.png">](https://github.com/rikrd/loudia)

Loudia is a Free Software audio processing library written in C++. It implements a variety of common processing blocks such as Windowing, FFT/IFFT, FIR/IIR Filters, onset detectors, pitch estimation, MFCC, LPC, NMF.

 - [Loudia](https://github.com/rikrd/loudia) (GNU/GPL v3 or later)

#### Geomerative
   [<img style="max-width: 200px; float: right; margin: 1em; overflow: auto;" src="{{ site.baseurl }}/assets/geomerative.jpg">](https://github.com/rikrd/geomerative)

Geomerative is a library for Processing. It extends 2D geometry operations to facilitate generative geometry. Includes a TrueType font and an SVG interpreters. This library exposes the shapes (such as vector drawings or typographies) in a more approchable way. Geomerative simplifies access to the paths, the handles and the points, making it easy to develop generative typography and geometry pieces in Processing.

 - [Geomerative](https://github.com/rikrd/geomerative) for Processing (Java)

#### Fisica

   <img style="clip: rect(0,100px,auto,auto); max-width: 200px; float: right; margin: 1em; overflow: auto;" src="{{ site.baseurl }}/assets/fisica.png">

Fisica is a wrapper around the 2D physics simulation library JBox2D. It tries to make it much easier to create physical models by exposing an object oriented API similar to PPhys2D physics library for Processing. This library was designed mainly for educational purposes.

 - [Fisica](https://github.com/rikrd/fisica) for Processing (Java)
