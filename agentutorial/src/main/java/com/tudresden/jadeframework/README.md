# JADE AGENTS

Java Agent Development Framework (JADE) - Softwareumgebung für die Entwicklung von Multi-Agenten-Systemen und Add-Ons, die FIPA-Standards für intelligente Agenten unterstützt.

Die JADE besteht aus:

- Eine dynamische Agentenleistungsumgebung (die Umgebung, in der JADE-Agenten "leben" können) . Agenten sind registriert und arbeiten unter der Kontrolle der Umgebung;
- eine Bibliothek von Klassen, die zur Entwicklung von Agentensystemen verwendet werden;
- eine Reihe von grafischen Werkzeugen zur Verwaltung und Überwachung des Live-Verhaltens von aktiven Agenten.

Das Jade-Framework wird in jedes Java-Projekt eingesteckt.

Die Agentenplattform verwaltet den Live-Agentenzyklus, bietet Nachrichten an und von Agenten und sucht nach Agenten.

Die Agentenplattform Jade für jede vielseitig Entwicklungsumgebung ist eine gemeinsame Bibliothek, die eingesteckt werden kann. Betrachten wir den Prozess der Verbindung unter Berücksichtigung des einzigen Unterschieds, der darin besteht, dass Sie beim Starten Jade ausführen und ihm die Namen der Agentenklassen als Parameter der Befehlsseite übergeben müssen.

# Anforderungen für die Agenten

Installieren Sie JADE und richten Sie die Eclipse-Umgebung entsprechend ein. 

Um zu prüfen, ob die Umgebung richtig eingerichtet ist, erstellen wir Testagenten: PingAgent, PongAgent. 


# Durchführung des Agents

Um die Agenten zu starten, müssen Sie Debug-Konfigurationen gestallten, das heiß den Projektnamen, die Haupklasse (jade.Boot)
und Argumente (-gui test1:com.tudresden.jadeframework.PingAgent; test2:com.tudresden.jadeframework.PongAgent) angeben. Daraufhin wird das Fenster Remote Agent Management GUI geöffnet. 
