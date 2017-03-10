---
layout: page
title: Research
permalink: /research/
---

## Topics
My research interests include speech perception and processing, music analysis, source separation, machine listening and unsupervised learning.

### Intelligibility modelling
#### Evaluation framework
Traditional intelligibility models are concerned with predicting the average number of words heard correctly in given noise conditions and can be readily tested by comparison with listener data. In contrast, recent `microscopic' intelligibility models, which attempt to make precise predictions about a listener's perception or misperception of specific utterances, have less well-defined goals and are hard to compare. 

We propose a novel evaluation framework that proposes a standardised procedure for microscopic model evaluation. The key problem is how to compare a model prediction made at a sublexical granularity with a set of listeners' lexical responses, especially considering that not all listeners will hear a given noisy target word in the same way. 

#### Consistent confusions

   [<img style="max-width: 200px; filter: invert(100%); float: right; margin: 1em; overflow: auto;" src="{{ site.baseurl }}/assets/consistent_confusion.png">](http://spandh.dcs.shef.ac.uk/ECCC/)

[The English Consistent Confusion Corpus](http://spandh.dcs.shef.ac.uk/ECCC/) is a large-scale collection of noise induced British English speech misperceptions. These misperceptions have been elicited by asking listeners to transcribe English words mixed with complex noise backgrounds.

The corpus has been distilled from over 300,000 listener responses and includes responses to over 9,000 individual noisy speech tokens. Of these, a subset of over 3,000 tokens induce 'consistent confusions', i.e. tokens that are misheard in the same way by a significant number of listeners.

### Vocal interactivity in-and-between humans, animals and robots

   [<img style="max-width: 200px; float: right; margin: 1em; overflow: auto;" src="{{ site.baseurl }}/assets/vihar_schema.png">](http://www.vihar.org)

Almost all animals exploit vocal signals for a range of ecologically-motivated purposes: from detecting predators/prey and marking territory, to expressing emotions, establishing social relations and sharing information.  Whether it is a bird raising an alarm, a whale calling to potential partners, a dog responding to human commands, a parent reading a story with a child, or a businessperson accessing stock prices using Siri on an iPhone, vocalisation provides a valuable communications channel through which behaviour may be coordinated and controlled, and information may be distributed and acquired.  Indeed, the ubiquity of vocal interaction has led to research across an extremely diverse array of fields, from assessing animal welfare, to understanding the precursors of human language, to developing voice-based human-machine interaction.

[VIHAR](http://www.vihar.org) is an community dedicated to the interdisciplinary study of vocal interactivity in-and-between humans, animal and robots. We have organised a [Dagstuhl seminar](http://www.dagstuhl.de/16442) in 2016 and are in the process or organising the [1st VIHAR Workshop](http://vihar2017.vihar.org) as a satellite event to INTERSPEECH 2017.


### Audio source separation
   <img style="max-width: 200px; float: right; margin: 1em; overflow: auto;" src="{{ site.baseurl }}/assets/source_separation.png">
   
Source separation in digital signal processing consists in finding the original signals that were mixed together into a set of observed signals. Solutions to this problem have been extensively studied for musical signals, however their application to real-world practical situations remains infrequent. There are two main obstacles for their widespread adoption depending on the scenario.  The main limitation in some cases is high latency and computational cost. In other cases the quality of the results is insufficient. Much work has gone toward improving the quality of music separation under general conditions. But few studies have been devoted to the development of low-latency and low computational cost separation of monaural signals, as well as to the separation quality of specific instruments.

My work on this topic addresses these issues in each of these scenarios independently.  First, I focused on methods with low computational cost and low latency. I proposed the use of Tikhonov regularization as a method for spectrum decomposition in the low-latency context. I compared it to existing techniques in pitch estimation and tracking tasks, crucial steps in many separation methods.  I then used the proposed spectrum decomposition method in low-latency separation tasks targeting singing voice, bass and drums. Second, I proposed several high-latency methods that improve the separation of singing voice by modeling components that are often not accounted for, such as breathiness and consonants.  Finally, I explore using temporal correlations and human annotations to enhance the separation of drums and complex polyphonic music signals.

### Unsupervised incremental clustering

   <img style="max-width: 200px; float: right; margin: 1em; overflow: auto;" src="{{ site.baseurl }}/assets/unsupervised_learning.png">

Guided by the idea that musical human-computer interaction may become more effective, intuitive, and creative when basing its computer part on cognitively more plausible learning principles, we employ unsupervised incremental online learning (i.e. clustering) to build a system that predicts the next event in a musical sequence, given as audio input.  Taking into account no previous knowledge, neither on the used sounds or instruments nor on the timing and rhythmical structure of the audio segment, the system starts from _tabula rasa_, performing predictions from the very first sound event.  The system adapts to pattern changes in the sequence as well as the appearance of new sounds or instruments at any time.

## Projects
 - [INSPIRE-ITN](http://www.inspire-itn.eu/) Investigating Speech Processing In Realistic Environments
 - [EmCAP](http://emcap.iua.upf.edu/) Emergent Cognition through Active Perception
 - [CloudCAST](http://cloudcast.rcweb.dcs.shef.ac.uk/) Clinical Applications of Speech Technology
 - Audio Object Modelling in Mixtures joint research project with Yamaha Corp.
 - Minus-One Technology (audio source separation) joint research project with Yamaha Corp.


## Activities
 - Organiser of the [Intelligibility under the Microscope](http://spandh.dcs.shef.ac.uk/2016_is_microintelligibility/) IS2016 special session
 - Co-organiser of the [CHiME3](http://spandh.dcs.shef.ac.uk/chime_challenge/chime2015/) & [CHiME4](http://spandh.dcs.shef.ac.uk/chime_challenge/) challenges
 - Co-organiser of the [CHiME 2016 workshop](http://spandh.dcs.shef.ac.uk/chime_workshop/)
 - Coordinator of the [VIHAR Dagstuhl seminar 2016](http://www.dagstuhl.de/16442)
 - Co-organiser of the [VIHAR 2017 workshop](http://vihar207.vihar.org)
