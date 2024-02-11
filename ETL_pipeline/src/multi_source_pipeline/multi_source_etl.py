import os, sys
current = os.path.dirname(os.path.realpath(__file__))
parent = os.path.dirname(current)
sys.path.insert(1, f"/{parent}/")
from src_utility import utility as src_utls
# Add two parent paths to sys.path
src_utls.add_parent_paths(3)
from common import utility as utls
